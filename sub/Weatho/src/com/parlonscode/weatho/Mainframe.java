package com.parlonscode.weatho;

import java.awt.Dimension;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.parlonscode.weatho.modele.CurrentWeather;
import com.parlonscode.weatho.utilities.API;
import com.parlonscode.weatho.utilities.Alert;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Mainframe extends JFrame {
	String forecasturl;
	private static final long serialVersionUID = 1L;
	
	private static final String GENERIC_EROR_MESSAGE = "Oops une erreur est survenur, veuillez ressayer";
	private static final String INTERNET__CONNECTIVITY_EROR_MESSAGE = "Veuillez verifier que vous etes bien connecte a internet";

	public Mainframe(String title) {
		super(title);
		
		double latitude = 37.8267;
		double longitude = -122.4233;
		
		
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(API.getForecastUrl(latitude, longitude)).build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response)  {
				try(ResponseBody body = response.body()) {
					if (response.isSuccessful()) {
					String jsonData = body.string();
					JSONObject forecast = (JSONObject) JSONValue.parseWithException(jsonData);
						CurrentWeather currentWeather = new CurrentWeather();
						JSONObject currently = (JSONObject) forecast.get("currently");
						currentWeather.setTimezone((String) forecast.get("timezone"));
						currentWeather.setTime((long)currently.get("time"));
						currentWeather.setTemperature(Double.parseDouble(currently.get("temperature") + ""));
						currentWeather.setHumidity(Double.parseDouble(currently.get("humidity") + ""));
						currentWeather.setPrecipProbability(Double.parseDouble(currently.get("preciProbability") + ""));
						currentWeather.setSummary((String) currently.get("summary"));

						System.out.println(currentWeather.getFormattedTime());
					/*	
					 * String timezone = (String) forecast.get("timezone");
						double temperature = Double.parseDouble(currently.get("temperature")+ "");
						long time = (long) currently.get("time");
						double humidity = Double.parseDouble(currently.get("humidity")+ "");
						double precipProbability = Double.parseDouble(currently.get("precipProbability") +"");
						String summary = (String) currently.get("summary");
						System.out.println(timezone);
						System.out.println(temperature);
						System.out.println(time);
						System.out.println(humidity);
						System.out.println(precipProbability);
						System.out.println(summary);
						Date date = new Date(time*1000L); 
						SimpleDateFormat formatter = new SimpleDateFormat("HH:mm"); 
						formatter.setTimeZone(TimeZone.getTimeZone(timezone)); 
						String timeString = formatter.format(date);
					    System.out.println(timeString);
					    
					    */
						
				}else {
					Alert.error(Mainframe.this, GENERIC_EROR_MESSAGE);
					
				}
				}catch (IOException | ParseException e) {
					Alert.error(Mainframe.this, GENERIC_EROR_MESSAGE);
				} 
				
				
				
					
			
				
			}
				
			
						
								
			
			
			@Override
			public void onFailure(Call call, IOException e) {
				Alert.error(Mainframe.this,INTERNET__CONNECTIVITY_EROR_MESSAGE );
			
				
				
			}
		});
	
	
		
		
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(500,500);
	}
	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return getPreferredSize();
	}
	
	@Override
	public Dimension getMaximumSize() {
		// TODO Auto-generated method stub
		return getPreferredSize();
	}
/*class ForecastWorker extends SwingWorker<String, Void> {
   private String forecastUrl;
   
	public ForecastWorker(String forecastUrl) {
		this.forecastUrl = forecastUrl;
	}
	@Override
	protected String doInBackground() throws Exception {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(forecasturl).build();
		Call call = client.newCall(request);
		try {
			Response reponse = call.execute();
			if (reponse.isSuccessful()) {
				return reponse.body().string();	
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error : " +e);
		}
		return null;
	
	}
	@Override
	protected void done() {
		try {
			System.out.println(get());
		} catch (Exception e) {
			System.err.println("Error :" +e);
		}
	}
}*/
}
