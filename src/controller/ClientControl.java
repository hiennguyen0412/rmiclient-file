package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import dao.ISinhVien;
import model.SinhVien;
import view.ClientView;

public class ClientControl { 
	private ClientView view;

	public ClientControl(ClientView view) {
		try {
			Registry registry;
			this.view = view;
			registry = LocateRegistry.getRegistry("localhost", 1234);
			
			/**
			 * Lookup Server Object
			 */
			ISinhVien dao = (ISinhVien) registry.lookup("SinhVien");

			while(true) {
				ArrayList<SinhVien> listSV;
				int choice = view.menu();
				switch(choice) {
				case 1:{//add
					SinhVien sv = view.nhapSV();
					
					dao.action(1, sv);
					break;
				}
				case 2:{//view
					
					listSV = (ArrayList<SinhVien>) dao.action(2,null);
					System.out.println("size: "+listSV.size());
					view.showListSV(listSV);
					break;
				}
				case 3:{//edit
					/**
					 * SinhVien cu
					 */
					SinhVien sv = view.search();
					/**
					 * SinhVien moi
					 */
					SinhVien sv1 = view.nhapSV();
					/* Set id sv moi voi id SV cu*/
					sv1.setMaSV(sv.getMaSV());
					if(dao.action(3, sv1).equals(new Boolean(true))) {
						view.showMess("Edit OK");
					}
					break;
				}
				case 4:{//delete
					SinhVien sv = view.search();
					if(dao.action(4, sv).equals(new Boolean(true))) {
						view.showMess("Delete OK");
					}
					break;
					
				}
				case 5:{//save
					if(dao.action(5, new SinhVien()).equals(new Boolean(true))) {
						view.showMess("Save OK");
					}
					break;
				}
				case 0:{
					System.exit(1);
					break;
				}
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
