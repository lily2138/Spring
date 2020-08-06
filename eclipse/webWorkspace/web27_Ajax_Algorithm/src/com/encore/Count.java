package com.encore;


public class Count {

	public String execute(String book) {
		String word = ""; // 가장 많이 나오는 단어

		//소문자 변환
		String lowerBook = book.toLowerCase();
		
		String [] words = lowerBook.split(" ");
		
		int max = 0; // 최대 빈도수를 의미
		int count = 0;
		
		for(int i = 0; i < words.length ; i++){
			count = 0; // 반복문이 한번 돌때마다 값을 초기화 해줌
			for(int j = 0 ; j < words.length ; j++){
			    if(words[i].equals(words[j])){
			     // 단어와 단어가 같다면 카운트를 증가
			     count++;
			    }
			}
			
			if(max < count){
				max = count;
				word = words[i];
			}
			if(max == count) {
				if(word.charAt(0)>=words[i].charAt(0)) {
					continue;
				}else {
					word=words[i];
				}
			}
		}
		
		
		
		
		return word;
	}

	public static void main(String[] args) {
		String book1 ="Can Danny and his father outsmart the villainous Mr. Hazell? Danny has a life any boy would love - his home is a gypsy caravan, he's the youngest master car mechanic around, and his best friend is his dad, who never runs out of wonderful stories to tell. But one night Danny discovers a shocking secret that his father has kept hidden for years. "; 
		String book2 ="Soon Danny finds himself the mastermind behind the most incredible plot ever attempted against nasty Victor Hazell, a wealthy landowner with a bad attitude. Can they pull it off? If so, Danny will truly be the champion of the world.";
		String book3 ="I like cat. I like cat. I like cat. ";
		Count c = new Count();
		System.out.println(c.execute(book1));
		System.out.println(c.execute(book2));
		System.out.println(c.execute(book3));

	}

}
