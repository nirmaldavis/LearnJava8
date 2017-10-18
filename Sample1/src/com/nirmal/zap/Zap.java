package com.nirmal.zap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Zap {

	public static void main(String[] args) {
		
		String[] myStringArray = new String[]{"Nirmal", "Joji", "Amar", "Paul"};
		List<String> list = Arrays.asList(myStringArray);
		
		
		System.out.println("Imperative style..");
		
		List<String> resultList = zap(list, "Amar");
		
		for (String string : resultList) {
			System.out.println(string);
		}
		
		System.out.println("Declarative style..");
		
		resultList = zap2(list, "Amar");
		
		resultList.forEach(System.out::println);
		
	}

	
	//Imperative style
	
	public static List<String> zap(List<String> lines, String omit) {
		List<String> res = new ArrayList<String>();
		
		for(String line : lines) {
			if(! omit.equals(line))
				res.add(line);
		}
		return res;
	}
	
	
	//Declarative style
	
	public static List<String> zap2(List<String> lines, String omit) {

		return lines
//				.stream()
				.parallelStream()
//				.filter( line -> !omit.equals(line) )
//				.filter( not (omit::equals))
				.filter(not(omit::equals))
				.collect(toList());
	}
	
	
	/**
     * A generic negation predicate that can be used to negate a
     * predicate.
     *
     * @return The negation of the input predicate.
     */
    public static<T> Predicate<T> not(Predicate<T> p) {
        return p.negate();
    }
    
}
