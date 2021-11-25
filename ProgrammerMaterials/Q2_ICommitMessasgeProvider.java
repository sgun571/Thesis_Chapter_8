
/**
 * This interface must be implemented to be a commit message provider.
 * A commit message provider provides the complete or a fragment of a
 * commit message. This message will be added to the text field in the
 * {@link CommitDialog}.
 * <br/>
 * Primarily use is the integration of mylyns commit templates.
 *
 * @see CommitDialog
 *
 * @author Thorsten Kamann <thorsten@itemis.de>
 * @since 0.10
 */
public interface ICommitMessageProvider {

    public String getMessage(IResource[] resources);
}