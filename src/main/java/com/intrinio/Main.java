package com.intrinio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.HttpClientBuilder;

import org.apache.http.HttpStatus;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;
import java.util.Iterator;

public class Main {
	private static final String USERNAME = "YOUR_API_USERNAME"; // Looks lik this : "7fk5312227a48bee16725187c6f46h78";
	private static final String PASSWORD = "YOUR_API_PASSWORD"; // Looks lik this : "9sns3239c867e41eedc3692a79ac998c";
	private static final Date TODAY = new Date();
	private static final SimpleDateFormat DT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws Exception {
		doGet();
    }

	private static void doGet() throws Exception {

		String startDt = DT_FORMAT.format(TODAY);
		System.out.println("TODAY is " + startDt);

		String basicUrl = "https://api.intrinio.com/";
		String symbol = "AAPL";
		//https://api.intrinio.com/data_point?identifier=MSFT&item=marketcap,dividend,basiceps,roe Wednesday, November 15, 2017
		//You can add more 'items' from https://intrinio.com/data-tags/company-financials

		String singleDayUrl = basicUrl + "prices?identifier="+symbol+"&start_date=2017-11-15";//+startDt;
		String dataPointUrl = basicUrl + "data_point?ticker="+symbol+"&item=open_price,last_price,close_price" +
			",volume,pricetoearnings,name,ticker,security_name,market_sector" +
			",security_type,stock_exchange,short_description,long_description" +
			",ceo,company_url,business_address,mailing_address,business_phone_no" +
			",employees,sector,industry_category,industry_group,price_date,totalrevenue,percent_change" +
			",marketcap,dividend,basiceps,roe";
		HttpGet httpGet = new HttpGet(dataPointUrl);

		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
		provider.setCredentials(AuthScope.ANY, credentials);
		  
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		 
		HttpResponse response = client.execute(httpGet);
		int statusCode = response.getStatusLine().getStatusCode();

		System.out.println("\nstatusCode is "+statusCode+"\n");
		HttpEntity httpEntity = response.getEntity();
		if (statusCode == HttpStatus.SC_OK) {
			String responseText = EntityUtils.toString(httpEntity);
			System.out.println(responseText+"\n\n");
			parseDataPointJson(responseText);
		} else System.out.println("\nOOPS! statusCode is "+statusCode+"\n");
	} // end

	private static void parseDataPointJson(String responseText) throws Exception {
		JSONObject jo = (JSONObject) new JSONParser().parse(responseText);

		// getting phoneNumbers
        JSONArray ja = (JSONArray) jo.get("data");

        // iterating data
        Iterator itr2 = ja.iterator();
		JSONObject jsonObject;
		CommonStock stock = new CommonStock();
		while (itr2.hasNext()) {
			while(itr2.hasNext()){
				jsonObject = (JSONObject)itr2.next();
				extractDataPointData(jsonObject,stock);
				//extractSingleDayData(jsonObject);
			}
        }
		System.out.println(stock);
	}

	private static void extractDataPointData(JSONObject jsonObject, CommonStock stock) throws java.text.ParseException {
		String item = (String) jsonObject.get("item");
		//System.out.println("\nItem: "+item);
		Object value = jsonObject.get("value");
		//System.out.println("Value : "+value+" "+value.getClass().getName());
		//System.out.println(jsonObject);
		double val;
		switch (item) {
			case "ticker" :	stock.setSymbol((String)value); break;
			case "last_price" :	stock.setLast((Double)value); break;
			case "pricetoearnings" : stock.setPe((Double)value); break;
			case "market_sector" : stock.setMarketSector((String)value); break;
			case "security_type" : stock.setType((String)value); break;
			case "stock_exchange" : stock.setExchange((String)value); break;
			case "long_description" : stock.setBusiness((String)value); break;
			case "ceo" : stock.setCeo((String)value); break;
			case "company_url" : stock.setUrl((String)value); break;
			case "business_address" : stock.setAddress((String)value); break;
			case "business_phone_no" : stock.setPhone((String)value); break;
			case "employees" : stock.setEmployees((Long)value); break;
			case "sector" : stock.setSector((String)value); break;
			case "industry_category" : stock.setIndustryCategory((String)value); break;
			case "industry_group" : stock.setIndustryGroup((String)value); break;
			case "price_date" : stock.setPriceDate(DT_FORMAT.parse((String)value)); break;
			case "percent_change" : stock.setChange((Double)value); break;
			case "marketcap" : stock.setMarketCap((Double)value); break;
			case "dividend" : stock.setDividend((Double)value); break;
			case "basiceps" : stock.setEps((Double)value); break;
			case "roe" : stock.setRoe((Double)value); break;
		}
	}

	private static void extractSingleDayData(JSONObject jsonObject) {
		Object date = jsonObject.get("date");
		System.out.println("Date : "+date+" "+date.getClass().getName());
		Object open = jsonObject.get("open");
		System.out.println("Open : "+open+" "+open.getClass().getName());
		Object high = jsonObject.get("high");
		System.out.println("High : "+high+" "+high.getClass().getName());
		Object low = jsonObject.get("low");
		System.out.println("Low : "+low+" "+low.getClass().getName());
		Object close = jsonObject.get("close");
		System.out.println("Close : "+close+" "+close.getClass().getName());
		Object volume = jsonObject.get("volume");
		System.out.println("Volume : "+volume+" "+volume.getClass().getName());
		//System.out.println(jsonObject);
	}

	static class CommonStock {
		private String symbol;
		private double open;
		private double last;
		private double close;
		private long volume;
		private double pe;
		private String name;
		private String ticker;
		private String securityName;
		private String marketSector;
		private String type;
		private String exchange;
		private String shortDesc;
		private String business;
		private String ceo;
		private String url;
		private String address;
		private String phone;
		private long employees;
		private String sector;
		private String industryCategory;
		private String industryGroup;
		private Date priceDate;
		private long revenue;
		private double change;
		private double marketCap;
		private double dividend;
		private double eps;
		private double roe;

		public String toString() { 
			return "\nCommonStock - \nSymbol : '" + this.symbol +
				"', \nQuote : " + this.last + ", \nP/E : " + this.pe + "" +
				"', \nVolume : " + this.volume + "" +
				"', \nMarket Sector : '" + this.marketSector + "'" +
				"', \nType : '" + this.type + "'" +
				"', \nExchange : '" + this.exchange + "'" +
				"', \nBusiness : '" + this.business + "'" +
				"', \nCeo : '" + this.ceo + "'" +
				"', \nUrl : '" + this.url + "'" +
				"', \nAddress : '" + this.address + "'" +
				"', \nPhone : " + this.phone + "" +
				"', \nEmployees # : " + this.employees + "" +
				"', \nSector : '" + this.sector + "'" +
				"', \nIndustry Category : '" + this.industryCategory + "'" +
				"', \nIndustry Group : '" + this.industryGroup + "'" +
				"', \nQuote Date : " + this.priceDate + "" +
				"', \nChange : " + this.change + "" +
				", \nMarket Cap : " + this.marketCap + "" +
				", \nDividend : " + this.dividend + "" +
				", \nEPS : " + this.eps + "" +
				", \nROE : " + this.roe + "";
		} 

		public String getSymbol() { return symbol; }
		public void setSymbol(String symbol) { 	this.symbol = symbol; }

		public double getOpen() { return open; }
		public void setOpen(double open) { this.open = open; }

		public double getLast() { return last; }
		public void setLast(double last) { this.last = last; }

		public double getClose() { return close; }
		public void setClose(double close) { this.close = close; }

		public long getVolume() { return volume; }
		public void setVolume(long volume) { this.volume = volume; }

		public double getPe() { return pe; }
		public void setPe(double pe) { this.pe = pe; }

		public String getName() { return name; }
		public void setName(String name) { this.name = name; }

		public String getTicker() { return ticker; }
		public void setTicker(String ticker) { this.ticker = ticker; }

		public String getSecurityName() { return securityName; }
		public void setSecurityName(String securityName) { this.securityName = securityName; }

		public String getMarketSector() { return marketSector; }
		public void setMarketSector(String marketSector) { this.marketSector = marketSector; }

		public String getType() { return type; }
		public void setType(String type) { this.type = type; }

		public String getExchange() { return exchange; }
		public void setExchange(String exchange) { this.exchange = exchange; }

		public String getShortDesc() { return shortDesc; }
		public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

		public String getBusiness() { return business; }
		public void setBusiness(String business) { this.business = business; }

		public String getCeo() { return ceo; }
		public void setCeo(String ceo) { this.ceo = ceo; }

		public String getUrl() { return url; }
		public void setUrl(String url) { this.url = url; }

		public String getAddress() { return address; }
		public void setAddress(String address) { this.address = address; }

		public String getPhone() { return phone; }
		public void setPhone(String phone) { this.phone = phone; }

		public long getEmployees() { return employees; }
		public void setEmployees(long employees) { this.employees = employees; }

		public String getSector() { return sector; }
		public void setSector(String sector) { this.sector = sector; }

		public String getIndustryCategory() { return industryCategory; }
		public void setIndustryCategory(String industryCategory) { this.industryCategory = industryCategory; }

		public String getIndustryGroup() { return industryGroup; }
		public void setIndustryGroup(String industryGroup) { this.industryGroup = industryGroup; }

		public Date getPriceDate() { return priceDate; }
		public void setPriceDate(Date priceDate) { this.priceDate = priceDate; }

		public long getRevenue() { return revenue; }
		public void setRevenue(long revenue) { this.revenue = revenue; }

		public double getChange() { return change; }
		public void setChange(double change) { this.change = change; }

		public double getMarketCap() { return marketCap; }
		public void setMarketCap(double marketCap) { this.marketCap = marketCap; }

		public double getDividend() { return dividend; }
		public void setDividend(double dividend) { this.dividend = dividend; }

		public double getEps() { return eps; }
		public void setEps(double eps) { this.eps = eps; }

		public double getRoe() { return roe; }
		public void setRoe(double roe) { this.roe = roe; }
	}
}
