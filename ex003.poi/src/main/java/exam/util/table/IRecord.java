package exam.util.table;

import java.util.Optional;

public interface IRecord {
	ITableMetaData getMetaData();
	
	Optional<String> getString(int i);
	default Optional<String> getString(String name){
		return getString(getMetaData().getFieldIndex(name));
	}

	default Optional<Long> getLong(int i){
		return getString(i).flatMap(s ->{
			try {
				return Optional.of(Long.parseLong(s));
			}
			catch(NumberFormatException e) {
				return Optional.empty();
			}
		});
	}
	default Optional<Long> getLong(String name){
		return getLong(getMetaData().getFieldIndex(name));
	}
	
	default Optional<Double> getDouble(int i){
		return getString(i).flatMap(s ->{
			try {
				return Optional.of(Double.parseDouble(s));
			}
			catch(NumberFormatException e) {
				return Optional.empty();
			}
		});
	}
	default Optional<Double> getDouble(String name){
		return getDouble(getMetaData().getFieldIndex(name));
	}
}
