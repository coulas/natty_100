package org.coulas.natty_100;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.joestelmach.natty.DateGroup;
import com.joestelmach.natty.Parser;

@RunWith(JUnitParamsRunner.class)
public class NattyParserTest {
	Parser p = new Parser();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Test
	@Parameters({
		"first monday in 1 month, 2015-02-02", 
		"first monday in 2 months, 2015-03-02", 
		"first monday in 3 months, 2015-04-06", 
		"first monday of month in 1 month, 2015-02-02", 
		"first monday of month in 2 months, 2015-03-02", 
		"first monday of month in 3 months, 2015-04-06", 
		"first monday of 1 month, 2015-02-02", 
		"first monday of 2 months, 2015-03-02", 
		"first monday of 3 months, 2015-04-06", 
	})
	public void shallParseGivenInExpected(String given, String expected) {
		List<DateGroup> dateGrps = p.parse(given);
		Assert.assertEquals(false, dateGrps == null);
		Assert.assertEquals(false, dateGrps.isEmpty());
		DateGroup dateGrp = dateGrps.get(0);
		Assert.assertEquals(false, dateGrp == null);
		List<Date> dates = dateGrp.getDates();
		Assert.assertEquals(false, dates == null);
		Assert.assertEquals(false, dates.isEmpty());
		Date actual = dates.get(0);
		System.out.println(given + " expects "+expected+" and gives " + format.format(actual));
		System.err.println(dateGrp.getSyntaxTree().toStringTree());
		Assert.assertEquals(given, expected, format.format(actual));
	}
}
