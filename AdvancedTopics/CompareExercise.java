package JavaProgmr;

import java.util.*;
import java.io.*;

class Movie implements Comparable<Movie>{
	private double rating;	
	private String name;
	private int year;
	
	// 생성자
	public Movie(String nm, double rt, int yr){
		this.rating = rt;
		this.name = nm;
		this.year = yr;
	}
	
	@Override
	public int compareTo(Movie m){
		// 오름차순 정렬
		return this.year - m.year;
	}
	
	// Getter Methods for Accessing private Data
	public double getRating(){
		return this.rating;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getYear(){
		return this.year;
	}
}


// Class to Compare Movies by [ ratings ]
class RatingCompare implements Comparator<Movie>{
	@Override
	// int 형으로 반환되기 때문에, 리턴 타입을 잘 확인한다.
	// 해당 비교 멤버필드는 double 형이기 때문에 따로 상세히 구현한 것이다.
	public int compare(Movie m1, Movie m2){
		if(m1.getRating() < m2.getRating()) 
			return -1;
		else if(m1.getRating() > m2.getRating())
			return 1;
		else 
			return 0;
	}
}


// Class to compare Movies by [ name ]
class NameCompare implements Comparator<Movie>{
	@Override
	public int compare(Movie m1, Movie m2){
		return m1.getName().compareTo(m2.getName());
	}
}


public class CompareExercise {
	public static void main(String[]args){
		/*
		 * 클래스의 멤버변수를 활용해서 정렬하는 두가지 인터페이스가 존재
		 * Comparable & Comparator 가 있다.
		 * 
		 * 객체와 객체가 비교가능하다면, Comparable 인터페이스를 구현한다.
		 * 해당 인터페이스에서 compareTo 메소드를 오버라이딩해서 멤버필드 기준으로 정렬한다.
		 * */
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("범죄도시", 9.35, 2017));
		list.add(new Movie("바그다드 카페", 9.33, 1987));
		list.add(new Movie("혐오스런 마츠코의 일생", 9.11, 2006));
		list.add(new Movie("파리대왕", 8.01, 1992));
		
		// 년도 기준 정렬
		Collections.sort(list);
		
		System.out.println("[ Movie Sorting ]");
		for(Movie movie : list)
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		
		/*
		 * >> 결과적으로 해당 클래스의 멤버변수를 통해서 다양한 기준을 잡고 소팅이 가능하다.
		 * >> name or rating or year 등과 같이...
		 * 
		 * 하지만 Comparable 을 통해서 비교하면 compareTo() 메소드는 딱 한번밖에 구현하지 못한다.
		 * 이에 대한 해결책으로 "Comparator" 을 사용하면 된다. 
		 * 
		 * Comparator 는 비교할 유형이 클래스 내부에 구현하는 것이 외부에 있다.
		 * 그것은 별도의 클래스이며, 서로 다른 멤버를 비교할 수 있도록 여러개의 Comparator 를 구현할 수 있다.
		 * */
		
		System.out.println("\n----------------------------------\n");
		
		// 평점에 의한 정렬 --
		System.out.println("[ Movie Sorting by Rating ]");
		Collections.sort(list, new RatingCompare());
		for(Movie movie : list)
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
		
		System.out.println("\n----------------------------------\n");
		
		// 영화명에 의한 정렬 --
		System.out.println("[ Movie Sorting by Name ]");
		Collections.sort(list, new NameCompare());
		for(Movie movie : list)
			System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
	
		
		/*
		 * Comparable 은 순서가 존재하는 객체를 의미한다.
		 * 따라서 객체 자체가 어떤 순서를 따를 것인지 지정되어야하며 알고있어야 한다.
		 * 
		 * 반면에 
		 * 
		 * Comparator 은 별도의 클래스를 통해서 수행된다.
		 * 
		 * 논리적으로 Comparable 인터페이스는 this 참조로 지정된 객체와 비교한다.
		 * Comparator 는 파라미터로 제공된 두 개의 다른 클래스 객체를 비교한다.
		 * Comparable 인터페이스를 구현하는 경우에는 List 혹은 Array 객체의 컬렉션 
		 * Collection.sort() 혹은 Arrays.sort() 메소드를 사용하여 자동으로 정렬이 가능하다.*/
		
		// [ Comparable : 객체의 정렬이 자연적 순서에 따라 정렬되길 원하는 경우 ]
		// [ Comparator : 서로 다른 객체의 속성에서 정렬해야 하는 경우 ]
	}
}
