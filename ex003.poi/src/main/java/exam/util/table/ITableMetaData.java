package exam.util.table;

/**
 * 
 */
public interface ITableMetaData {
	/**
	 * 
	 * @return
	 */
	String[] getFieldNames();
	/**
	 * 
	 * @param name
	 * @return
	 */
	int getFieldIndex(String name);
}
