package com.entreprise.rh;

import com.entreprise.exceptions.MontantInvalideException;

public interface Augmentable {
	public static double TAUX_MAX = 0.20;
	
	public void augmenter(double taux) throws MontantInvalideException;
	
	public default void augmenterStandard() throws MontantInvalideException {
		this.augmenter(0.05);
	}
}