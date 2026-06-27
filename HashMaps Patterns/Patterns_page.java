      // 1. getOrDefault: safe frequency counting
       Map<Character,Integer>  map2 = new HashMap<>();
       map2.getOrDefault(key,0);//returns 0 if key not found


        // 2. computeIfAbsent: build adjacency lists cleanly
       Map<Integer,ArrayList<Integer>> map3 = new HashMap<>();
       map3.computeIfAbsent(node,k-> new ArrayList<>()).add(neighbour);

       // 3. merge: concise frequency counting
       map.merge(key,1,integer::sum);

       //4. putIfAbsent: set a value only if key is not already present
       map2.putIfAbsent(key,defaultValue);

       // 5. entrySet: iterate over key-value pairs
       for (Map.Entry<String, Integer> entry : map.entrySet()) {
           String key = entry.getKey();
           int value = entry.getValue();
       }
