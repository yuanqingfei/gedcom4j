package com.mattharrah.gedcom4j.comparators;

import java.util.Comparator;

import com.mattharrah.gedcom4j.Individual;

/**
 * Comparator for sorting individuals by last name (surname) first, then first
 * (given) name
 * 
 * @author frizbog1
 * 
 */
public class IndividualByLastNameFirstNameComparator implements
        Comparator<Individual> {

	@Override
	public int compare(Individual i1, Individual i2) {

		String n1 = "-unknown-";
		if (i1.names.size() > 0 && i1.names.get(0) != null) {
			n1 = i1.names.get(0).toString();
		}
		String n2 = "-unknown-";
		if (i2.names.size() > 0 && i2.names.get(0) != null) {
			n2 = i2.names.get(0).toString();
		}

		return n1.compareTo(n2);
	}

}
