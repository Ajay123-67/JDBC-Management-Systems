package dao;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {

        String sql = "insert into customers(customer_name,phone,email,address) values(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getAddress());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Customer> getAllCustomers(){

        ArrayList<Customer> list=new ArrayList<>();

        String sql="select * from customers";

        try(Connection con=DBConnection.getConnection();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql)){

            while(rs.next()){

                Customer c=new Customer();

                c.setCustomerId(rs.getInt("customer_id"));
                c.setCustomerName(rs.getString("customer_name"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));

                list.add(c);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public boolean updateCustomer(Customer customer){

        String sql="update customers set customer_name=?,phone=?,email=?,address=? where customer_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setString(1,customer.getCustomerName());
            ps.setString(2,customer.getPhone());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getAddress());
            ps.setInt(5,customer.getCustomerId());

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteCustomer(int id){

        String sql="delete from customers where customer_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            return ps.executeUpdate()>0;

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public Customer searchCustomer(int id){

        String sql="select * from customers where customer_id=?";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){

            ps.setInt(1,id);

            ResultSet rs=ps.executeQuery();

            if(rs.next()){

                Customer c=new Customer();

                c.setCustomerId(rs.getInt("customer_id"));
                c.setCustomerName(rs.getString("customer_name"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));

                return c;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}