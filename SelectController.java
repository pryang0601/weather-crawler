package final_project;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.awt.event.ActionListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
public class SelectController extends seleniumtest implements Initializable {	
	seleniumtest s=new seleniumtest();
	@FXML
	MediaView mv;
	@FXML
	ComboBox city;
	@FXML
	Button search;
	@FXML
	TextField temperature;
	@FXML
	public Label umbrella;
	@FXML
	TextField weathers;
	@FXML
	ImageView um;
	@FXML
	ImageView cloudy;
	@FXML
	ImageView rainy;
	@FXML
	ImageView sunny;
	@FXML
	Button cloths;
	@FXML
	Button alert;
	@FXML
	Button end;
	@FXML
	ImageView a;
	@FXML
	ImageView c;
	String path_wind="/Users/pryang/Documents/final_project_music/zapsplat_nature_wind_cold_blizzard_constant_droning_designed_001_69022.mp3";
	String path_rain="/Users/pryang/Documents/final_project_music/Stereo-Rain-And-Wind-A-www.fesliyanstudios.com.mp3";
	String path_sun="/Users/pryang/Documents/final_project_music/Ambient-Birds-Singing-A1-www.fesliyanstudios.com.mp3";
	Media media_wind=new Media(new File(path_wind).toURI().toString());
	Media media_rain=new Media(new File(path_rain).toURI().toString());
	Media media_sun=new Media(new File(path_sun).toURI().toString());
	MediaPlayer wind=new MediaPlayer(media_wind);
	MediaPlayer rain=new MediaPlayer(media_rain);
	MediaPlayer sun=new MediaPlayer(media_sun);
	@FXML
	public void onSearchPress(ActionEvent e) {
		
		int index=city.getSelectionModel().getSelectedIndex();
		String weather="";
		final_project.city_record=index;
		temperature.setText((String) final_project.result_tem.get(index));
		final_project.tem_record=temperature.getText();
		weather=(String) final_project.result_weather.get(index);
		final_project.weather_record=weather;
		weathers.setText(weather);
		if(weather.equals("????????????")==true || weather.equals("?????????")==true) {
			umbrella.setVisible(true);
			umbrella.setText("???????????????????????????");
			um.setVisible(true);
			rainy.setVisible(true);
			sunny.setVisible(false);
			cloudy.setVisible(false);
			rain.play();
			sun.stop();
			wind.stop();
		}
		if(weather.equals("???")==true || weather.equals("????????????")==true ){
			sunny.setVisible(true);
			umbrella.setVisible(false);
			um.setVisible(false);
			rainy.setVisible(false);
			cloudy.setVisible(false);
			sun.play();
			wind.stop();
			rain.stop();
		}
		if(weather.equals("????????????")==true || weather.equals("???")==true || weather.equals("??????")==true){
			cloudy.setVisible(true);
			sunny.setVisible(false);
			umbrella.setVisible(false);
			um.setVisible(false);
			rainy.setVisible(false);
			wind.play();
			sun.stop();
			rain.stop();
		}
		cloths.setVisible(true);
		alert.setVisible(true);
		c.setVisible(true);
		a.setVisible(true);
	}
	@FXML
	public void OnEndPressed() {
		final_project.currentStage.close();
	}
	@FXML
	public void OnSelectPressed() throws IOException {
		rain.stop();
		sun.stop();
		wind.stop();
		Parent Short=FXMLLoader.load(getClass().getResource("choose.fxml"));
		Scene choosescene=new Scene(Short);
		choosescene.getRoot().requestFocus();
		final_project.currentStage.setScene(choosescene);
		final_project.currentStage.setTitle("Choose Cloths");
	}
	@FXML
	public void checkalert() throws IOException {
		rain.stop();
		sun.stop();
		wind.stop();
		Parent a=FXMLLoader.load(getClass().getResource("alert.fxml"));
		Scene alertscene=new Scene(a);
		alertscene.getRoot().requestFocus();
		final_project.currentStage.setScene(alertscene);
		final_project.currentStage.setTitle("WARNINGS");
		final_project.count++;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(final_project.return_count()==0) {//???????????????
			//seleniumtest s=new seleniumtest();
			s.get();//????????????
			for(int i=0;i<s.get_city().size()-2;i++) {//?????????weather??????????????????????????????????????????1or2)
				final_project.option_city.add(s.get_city().get(i));//ArrayList???????????????????????????
				final_project.result_tem.add(s.get_tem().get(i));//ArrayList?????????????????????????????????
				final_project.result_weather.add(s.get_weather().get(i));//ArrayList???????????????????????????????????????
			}
			for(int i=0;i<final_project.option_city.size();i++)
				city.getItems().add(final_project.option_city.get(i));//combobox????????????????????????
		}
		else {
			temperature.setText(final_project.tem_record);//??????????????????????????????????????????
			city.setValue(final_project.option_city.get(final_project.city_record));//combobox??????????????????????????????
			weathers.setText(final_project.weather_record);
			for(int i=0;i<final_project.option_city.size();i++)
				city.getItems().add(final_project.option_city.get(i));
			a.setVisible(true);
			c.setVisible(true);
			alert.setVisible(true);
			cloths.setVisible(true);
		}
	}
}
