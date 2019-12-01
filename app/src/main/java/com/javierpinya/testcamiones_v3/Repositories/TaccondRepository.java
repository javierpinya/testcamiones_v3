package com.javierpinya.testcamiones_v3.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.javierpinya.testcamiones_v3.AppDatabase;
import com.javierpinya.testcamiones_v3.Clases.TaccondEntity;
import com.javierpinya.testcamiones_v3.Dao.TaccondDao;

import java.util.List;

public class TaccondRepository {

    private TaccondDao taccondDao;

    public TaccondRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        taccondDao = db.taccondDao();
    }

    public LiveData<List<TaccondEntity>> findTaccondByConductor(String conductor){
        return taccondDao.findTaccondByConductor(conductor);
    }

    public LiveData<List<TaccondEntity>> findAllTaccond(){
        return taccondDao.findAllTaccond();
    }

    public LiveData<List<TaccondEntity>> findTaccondByDni(String dni){
        return taccondDao.findTaccondByDni(dni);
    }

    public LiveData<List<TaccondEntity>> findTaccondByApellidos(String apellidos){
        return taccondDao.findTaccondByApellidos(apellidos);
    }

    public LiveData<List<TaccondEntity>> findTaccondByNombre(String nombre){
        return taccondDao.findTaccondByNombre(nombre);
    }

    public TaccondEntity findTaccondById(int id){
        return taccondDao.findTaccondById(id);
    }

    public void insertTaccond(TaccondEntity taccond){
        new insertAsyncTask(taccondDao).execute(taccond);
    }

    private static class insertAsyncTask extends AsyncTask<TaccondEntity, Void, Void>{

        private TaccondDao asyncTaskDao;

        insertAsyncTask(TaccondDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccondEntity... taccondEntities) {
            asyncTaskDao.insertTaccond(taccondEntities[0]);
            return null;
        }
    }

    public void updateTaccond(TaccondEntity taccond){
        new updateAsyncTask(taccondDao).execute(taccond);
    }


    private static class updateAsyncTask extends AsyncTask<TaccondEntity, Void, Void>{

        private TaccondDao asyncTaskDao;

        updateAsyncTask(TaccondDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccondEntity... taccondEntities) {
            asyncTaskDao.updateTaccond(taccondEntities[0]);
            return null;
        }
    }

    public void deleteTaccondById(TaccondEntity taccond){
        new deleteAsyncTask(taccondDao).execute(taccond);
    }

    private static class deleteAsyncTask extends AsyncTask<TaccondEntity, Void, Void>{

        private TaccondDao asyncTaskDao;

        deleteAsyncTask(TaccondDao dao){ asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccondEntity... taccondEntities) {
            asyncTaskDao.deleteTaccondById(taccondEntities[0]);
            return null;
        }
    }

    public void deleteAllTaccond(){
        new deleteAllAsyncTask(taccondDao).execute();
    }

    private static class deleteAllAsyncTask extends AsyncTask<TaccondEntity, Void, Void>{
        private TaccondDao asyncTaskDao;

        deleteAllAsyncTask(TaccondDao dao) { asyncTaskDao = dao; }

        @Override
        protected Void doInBackground(TaccondEntity... taccondEntities) {
            asyncTaskDao.deleteAllTaccond();
            return null;
        }
    }

}
