package schedule.service;

import org.json.simple.JSONArray;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ExportService extends Remote{

    void push(JSONArray array) throws RemoteException;

}
