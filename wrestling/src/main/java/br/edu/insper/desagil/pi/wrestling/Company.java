package br.edu.insper.desagil.pi.wrestling;

import java.util.List;

public class Company {
	private List<SingleMatch> singleMatches;
	private List<TagMatch> tagMatches;

	public int points(Wrestler wrestler) {
		int points = 0;

		int id = wrestler.getId();

		for (SingleMatch match : singleMatches) {
			if (match.getWinner() == id) {
				points += 2;
			}
		}

		for (TagMatch match : tagMatches) {
			if (match.getWinnerFirst() == id || match.getWinnerSecond() == id) {
				points += 1;
			}
		}

		return points;
	}
}
