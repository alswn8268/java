package com.tjoeun.score;

import java.util.ArrayList;

// 여러 학생의 성적을 기억하는 클래스
public class ScoreList {

	private ArrayList<ScoreVO> scoreList = new ArrayList<>();

	public ArrayList<ScoreVO> getScoreList() {
		return scoreList;
	}
	public void setScoreList(ArrayList<ScoreVO> scoreList) {
		this.scoreList = scoreList;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "========================================\n";
		str += "번호 이름 java jsp spring 총점 평균 석차\n";
		str += "========================================\n";
		for (int i = 0; i < scoreList.size() - 1; i++) {
			for (int j = i+1; j < scoreList.size(); j++) {
//				i번째 학생의 평균이 크면 j번째 학생의 석차를 증가, j번째 학생의 평균이 크면 i번째 학생의 석차를 증가시킨다.
//				scoreList.get(i) => 1번째 학생의 전체 데이터
//				scoreList.get(i).getAverage => i번째 학생의 총점 데이터
				if (scoreList.get(i).getAverage() < scoreList.get(j).getAverage()) {					
					scoreList.get(i).setRank(scoreList.get(i).getRank() + 1);
				} else if (scoreList.get(i).getAverage() > scoreList.get(j).getAverage()) {
					scoreList.get(j).setRank(scoreList.get(j).getRank() + 1);					
				}
			}
		}
		for (ScoreVO vo : scoreList) {
			str += vo + "\n";
		}
		str += "=======================================\n";
		return str;
	}
	
//	arrayList에 성적 데이터를 추가하는 메소드
	public void addScore(ScoreVO score) {
		scoreList.add(score);		
	}
	
	
	
}
