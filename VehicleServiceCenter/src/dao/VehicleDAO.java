package dao;

import model.Vehicle;

import java.sql.*;
import java.util.ArrayList;

public class VehicleDAO {

    public boolean addVehicle(Vehicle vehicle){

        String sql="insert into vehicles(customer_id,vehicle_number,brand,model,manufacture_year) values(?,?,?,?,?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,vehicle.getCustomerId());
            ps.setString(2,vehicle.getVehicleNumber());
            ps.setString(3,vehicle.getBrand());
            ps.setString(4,vehicle.getModel());
            ps.setInt(5,vehicle.getManufactureYear());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Vehicle> getAllVehicles(){

        ArrayList<Vehicle> list=new ArrayList<>();

        String sql="select * from vehicles";

        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            while(rs.next()){

                Vehicle v=new Vehicle();

                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setCustomerId(rs.getInt("customer_id"));
                v.setVehicleNumber(rs.getString("vehicle_number"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setManufactureYear(rs.getInt("manufacture_year"));

                list.add(v);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateVehicle(Vehicle vehicle){

        String sql="update vehicles set customer_id=?,vehicle_number=?,brand=?,model=?,manufacture_year=? where vehicle_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,vehicle.getCustomerId());
            ps.setString(2,vehicle.getVehicleNumber());
            ps.setString(3,vehicle.getBrand());
            ps.setString(4,vehicle.getModel());
            ps.setInt(5,vehicle.getManufactureYear());
            ps.setInt(6,vehicle.getVehicleId());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteVehicle(int id){

        String sql="delete from vehicles where vehicle_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public Vehicle searchVehicle(String vehicleNumber){

        String sql="select * from vehicles where vehicle_number=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,vehicleNumber);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Vehicle v=new Vehicle();

                v.setVehicleId(rs.getInt("vehicle_id"));
                v.setCustomerId(rs.getInt("customer_id"));
                v.setVehicleNumber(rs.getString("vehicle_number"));
                v.setBrand(rs.getString("brand"));
                v.setModel(rs.getString("model"));
                v.setManufactureYear(rs.getInt("manufacture_year"));

                return v;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
