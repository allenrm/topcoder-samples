import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.List;


public class Aaagmnrs {
	public String[] anagrams(String[] phrases) {
		Set<Map<Character, Integer>> cache = new HashSet<Map<Character, Integer>>();
		List<String> anagrams = new ArrayList<String>();

		for( String phrase : phrases ) {
			Map<Character, Integer> map = convert(phrase);

			if( cache.isEmpty() || !exists(cache, map) ) {
				cache.add(map);
				anagrams.add(phrase);
			}
		}

		return anagrams.toArray(new String[0]);
	}

	private boolean exists(Set<Map<Character, Integer>> cache, Map<Character, Integer> phraseMap) {
		boolean exists = false;
		boolean matches = true;

		for( Map<Character, Integer> cacheMap : cache ) {
			matches = true;
			
			for( Character cacheKey : cacheMap.keySet() ) {
				if( !phraseMap.containsKey(cacheKey) || phraseMap.get(cacheKey) != cacheMap.get(cacheKey) ) {
					matches = false;
					break;
				}
			}

			exists |= matches;
		}

		return exists;
	}

	private Map<Character, Integer> convert(String phrase) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();

		for( Character key : format(phrase).toCharArray() ) {
			if( !map.containsKey(key) ) {
				map.put(key, 0);
			}

			map.put(key, map.get(key) + 1);
		}

		return map;
	}
	
	private String format(String phrase) {
		return phrase.toUpperCase().replaceAll("\\W", "");
	}
}