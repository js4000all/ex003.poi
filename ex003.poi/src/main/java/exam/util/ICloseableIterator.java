package exam.util;

import java.util.Iterator;

public interface ICloseableIterator<E, X extends Exception> extends Iterator<E>, AutoCloseable {
	@Override
	void close() throws X;
}
