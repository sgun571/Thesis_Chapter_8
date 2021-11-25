
    /**
     * Counts the number of wait requested. It avoids removing the waiting
     * cursor, since there may be multiple requests running at the same time.
     */
    private int fWaitCursorCount = 0;




    /**
     * Initializes the viewer with the information received.
     *
     * @param statViewer
     *            The statistics viewer for which the input will be set
     * @param traces
     *            The list of the traces to add in the tree.
     * @since 2.0
     */
    public void setInput(TmfStatisticsViewer statViewer, ITmfTrace[] traces) {
        String treeID = statViewer.getTreeID();
        if (TmfStatisticsTreeRootFactory.containsTreeRoot(treeID)) {
            // The experiment root is already present
            TmfStatisticsTreeNode experimentTreeNode = TmfStatisticsTreeRootFactory.getStatTreeRoot(treeID);

            // check if there is partial data loaded in the experiment
            int numTraces = traces.length;
            int numNodeTraces = experimentTreeNode.getNbChildren();

            if (numTraces == numNodeTraces) {
                boolean same = true;
                /*
                 * Detect if the experiment contains the same traces as when
                 * previously selected
                 */
                for (int i = 0; i < numTraces; i++) {
                    String traceName = traces[i].getName();
                    if (!experimentTreeNode.containsChild(traceName)) {
                        same = false;
                        break;
                    }
                }

                if (same) {
                    // no need to reload data, all traces are already loaded
                    statViewer.setInput(experimentTreeNode);

                    return;
                }
                experimentTreeNode.reset();
            }
        } else {
            TmfStatisticsTreeRootFactory.addStatsTreeRoot(treeID, statViewer.getStatisticData());
        }

        TmfStatisticsTreeNode treeModelRoot = TmfStatisticsTreeRootFactory.getStatTreeRoot(treeID);

        // if the model has contents, clear to start over
        if (treeModelRoot.hasChildren()) {
            treeModelRoot.reset();
        }

        // set input to a clean data model
        statViewer.setInput(treeModelRoot);
    }

     /**
     * Checks if statistic update is ongoing. If it is ongoing the new time
     * range is stored as pending
     *
     * @param timeRange
     *            - new time range
     * @return true if statistic update is ongoing else false
     */
    protected boolean checkUpdateBusy(TmfTimeRange timeRange) {
        synchronized (fStatisticsUpdateSyncObj) {
            if (fStatisticsUpdateBusy) {
                fStatisticsUpdatePending = true;
                if (fStatisticsUpdateRange == null
                        || timeRange.getEndTime().compareTo(fStatisticsUpdateRange.getEndTime()) > 0) {
                    fStatisticsUpdateRange = timeRange;
                }
                return true;
            }
            fStatisticsUpdateBusy = true;
            return false;
        }
    }