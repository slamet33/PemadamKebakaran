package id.slametriyadi.pemadamkebakaran.Network;

import id.slametriyadi.pemadamkebakaran.model.ResponseDataPegawai;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiService {

    @GET("petugaspemadam")
    Call<ResponseDataPegawai> getData(
            @Header("Authorization") int authorization
    );
}