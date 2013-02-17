package org.spoutcraft.launcher.util;

import java.util.List;

/**
 *
 * This is the 3rd version of SwingWorker (also known as
 * SwingWorker 3), an abstract class that you subclass to
 * perform GUI-related work in a dedicated thread.  For
 * instructions on using this class, see:
 *
 * http://java.sun.com/docs/books/tutorial/uiswing/misc/threads.html
 *
 * Note that the API changed slightly in the 3rd version:
 * You must now invoke start() on the SwingWorker after
 * creating it.
 *
 * @version $Revision: 971 $
 */
public abstract class SwingWorker<T, V> extends org.jdesktop.swingworker.SwingWorker<T, V> {
	/**
	 * This is a wrapper for get()
	 *
	 * @return T
	 */
	public T getValue() {
		try {
			return super.get();
		} catch( Exception ex) {
			return null;
		}
	}

	/**
	 * Receives data chunks from the {@code publish} method asynchronously on the
	 * <i>Event Dispatch Thread</i>.
	 * <p/>
	 * <p/>
	 * Please refer to the {@link #publish} method for more details.
	 *
	 * @param chunks intermediate results to process
	 * @see #publish
	 */
	@Override
	protected void process(List<V> chunks) {
		super.process(chunks);
	}
}
