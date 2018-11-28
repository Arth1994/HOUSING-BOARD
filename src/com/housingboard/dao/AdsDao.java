package com.housingboard.dao;

import java.util.List;

import com.housingboard.model.Ads;
import com.housingboard.model.Filters;
import com.housingboard.model.SearchFilters;
import com.housingboard.model.UserAdDetails;

/**
 * @author nitish
 */
public interface AdsDao {
	
	
	//return Ads based on the search field entered
	
	public List<Ads> getSearchResults(String searchField);

	public List<Ads> getSearchResultsByPage(String searchFieldController, int pageid, int total);

	public boolean createNewAd(Ads adModel);

	public List<Ads> getSearchResultsByPageByFilter(String searchFieldController, int pageid, int total,
			Filters filterObj);

	public Ads getDetailsOfAd(int adID);

	public UserAdDetails getDetailsOfUserAndAd(int adID);

	public List<Ads> getSearchTotalResultsByPageByFilter(String searchFieldController, int total, Filters filterObj);


}
