package exam.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class Streams {
	private Streams() {}

	/**
	 * IteratorをStreamとして扱う。
	 * @param it
	 * @return
	 */
	public static <T> Stream<T> asStream(Iterable<? extends T> iterable){
		return asStream(iterable.iterator());		
	}
	/**
	 * IteratorをStreamとして扱う。
	 * @param it
	 * @return
	 */
	public static <T> Stream<T> asStream(Iterator<? extends T> it){
		Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(it, 0);
		return StreamSupport.stream(spliterator, false);
	}
	/**
	 * IteratorをStreamとして扱う。戻り値のStreamを閉じるとIteratorも閉じられる。
	 * @param it
	 * @return
	 */
	public static <T> Stream<T> asStream(ICloseableIterator<? extends T, ?> it){
		Runnable closer = () ->{
			try {
				it.close();
			}
			catch(RuntimeException e) {
				throw e;
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
		};
		return Streams.<T>asStream((Iterator<? extends T>)it).onClose(closer);
	}

}
