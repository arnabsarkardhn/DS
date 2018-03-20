package com.arnab.BST;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class {@code CustomValidatorFactory} keeps track of validator objects.
 * Also it keeps a mapping between fields and their validation type  
 *
 */
class ValidationInvoker<K, V> {
	
	private Map<Class<?>, List<KeyPair<K, V>>> map = 
			new HashMap<Class<?>, List<KeyPair<K, V>>>();
	
	public List<KeyPair<K, V>> getKey(Class<?> clazz) {
		return map.get(clazz);
	}

	public List<KeyPair<K, V>> addKeyFieldValidations(K key, List<KeyPair<K, V>> list, V value) {
		list.add(new KeyPair<K, V>(key, value));
		return list;
	}
	
	public static class KeyPair<K, V> {
		private final K key;
		private final V value;
		
		KeyPair(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
		
	}
	
}


