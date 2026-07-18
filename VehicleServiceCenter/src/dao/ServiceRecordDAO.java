package dao;

import model.ServiceRecord;

import java.sql.*;
import java.util.ArrayList;

public class ServiceRecordDAO {

    public boolean addService(ServiceRecord service){

        String sql="insert into service_records(vehicle_id,service_date,service_type,cost,status) values(?,?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,service.getVehicleId());
            ps.setDate(2,service.getServiceDate());
            ps.setString(3,service.getServiceType());
            ps.setDouble(4,service.getCost());
            ps.setString(5,service.getStatus());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<ServiceRecord> getAllServices(){

        ArrayList<ServiceRecord> list=new ArrayList<>();

        String sql="select * from service_records";

        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            while(rs.next()){

                ServiceRecord s=new ServiceRecord();

                s.setServiceId(rs.getInt("service_id"));
                s.setVehicleId(rs.getInt("vehicle_id"));
                s.setServiceDate(rs.getDate("service_date"));
                s.setServiceType(rs.getString("service_type"));
                s.setCost(rs.getDouble("cost"));
                s.setStatus(rs.getString("status"));

                list.add(s);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateService(ServiceRecord service){

        String sql="update service_records set vehicle_id=?,service_date=?,service_type=?,cost=?,status=? where service_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,service.getVehicleId());
            ps.setDate(2,service.getServiceDate());
            ps.setString(3,service.getServiceType());
            ps.setDouble(4,service.getCost());
            ps.setString(5,service.getStatus());
            ps.setInt(6,service.getServiceId());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteService(int id){

        String sql="delete from service_records where service_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void viewServiceHistory(){

        String sql=
                "SELECT c.customer_name,v.vehicle_number,v.brand,v.model," +
                "s.service_date,s.service_type,s.cost,s.status " +
                "FROM customers c " +
                "JOIN vehicles v ON c.customer_id=v.customer_id " +
                "JOIN service_records s ON v.vehicle_id=s.vehicle_id";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){

            while(rs.next()){

                System.out.println("-----------------------------------");
                System.out.println("Customer Name : "+rs.getString("customer_name"));
                System.out.println("Vehicle Number : "+rs.getString("vehicle_number"));
                System.out.println("Brand : "+rs.getString("brand"));
                System.out.println("Model : "+rs.getString("model"));
                System.out.println("Service Date : "+rs.getDate("service_date"));
                System.out.println("Service Type : "+rs.getString("service_type"));
                System.out.println("Cost : "+rs.getDouble("cost"));
                System.out.println("Status : "+rs.getString("status"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
