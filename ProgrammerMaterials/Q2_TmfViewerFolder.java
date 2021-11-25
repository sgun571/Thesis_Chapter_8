    /**
     * Gets the folder that will be use as the parent of tabs that will hold the
     * viewer.
     *
     * In order to be able to add new tabs in this view, the parent of the
     * viewer control has to be this composite.
     *
     * @return the folder composite to use as the parent for the viewer control
     *         to create.
     */
    public Composite getParentFolder() {
        return fFolder;
    }