package studio.angzai.a10119123_mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    private MutableLiveData<String> kilometer;
    private MutableLiveData<String> centimeter;
    private Meter meter;
    MainActivity view;

    public MainViewModel() {
        kilometer = new MutableLiveData<>();
        centimeter = new MutableLiveData<>();
        meter = Meter.getInstance();
    }

    public LiveData<String> getKilometer() {
        return kilometer;
    }

    public LiveData<String> getCentimeter() {
        return centimeter;
    }

    public void calculateLength(String s) {

        String meter = view.getMeter();
        if (meter.isEmpty())
            meter = "0";

        Meter model = Meter.getInstance();
        double parsedMeter = Double.parseDouble(meter);
        model.setMeter(parsedMeter);

        model.toCentimeter();
        model.toKilometer();
    }
}