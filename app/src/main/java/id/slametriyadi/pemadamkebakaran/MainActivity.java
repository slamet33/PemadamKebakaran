package id.slametriyadi.pemadamkebakaran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.slametriyadi.pemadamkebakaran.Network.ApiService;
import id.slametriyadi.pemadamkebakaran.Network.InstanceRetrofit;
import id.slametriyadi.pemadamkebakaran.model.DataItem;
import id.slametriyadi.pemadamkebakaran.model.ResponseDataPegawai;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<ResponseDataPegawai> dataPegawai;
    @BindView(R.id.list_petugas)
    RecyclerView listPetugas;
    String token = "5h30dB4K4Uwuhj4KkmHmFtTClJ/ESwOrSukJxjCuBRXrMKYnYvBIZRr8OwmOlnSq";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getAuthorization();
        getData();

    }

    private void getAuthorization() {
        ApiService api = InstanceRetrofit.getInstance();
        retrofit2.Call<DataItem> call = api.getData(token);
        call.enqueue(new Callback<ResponseDataPegawai>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseDataPegawai> call, Response<ResponseDataPegawai> response) {
                if (response.body().getStatus().equals("success")){
                    Toast.makeText(MainActivity.this, ""+response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    List<DataItem> data = response.body().getData();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseDataPegawai> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {

    }
}
