package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session1 = factory.openSession();
        Transaction tx1 = session1.beginTransaction();

        Invoice inv1 = new Invoice("INV-2024-001", LocalDate.of(2024, 1, 10),
                "PAID", "Ravi Kumar", 15000.00, "Software Development - Jan 2024");

        Invoice inv2 = new Invoice("INV-2024-002", LocalDate.of(2024, 2, 14),
                "PENDING", "Sita Devi", 8500.50, "UI/UX Design - Feb 2024");

        Invoice inv3 = new Invoice("INV-2024-003", LocalDate.of(2024, 3, 22),
                "CANCELLED", "Arun Sharma", 3200.75, "Database Admin - Mar 2024");

        Invoice inv4 = new Invoice("INV-2024-004", LocalDate.of(2024, 4, 5),
                "PAID", "Priya Nair", 22000.00, "Cloud Setup - Apr 2024");

        Invoice inv5 = new Invoice("INV-2024-005", LocalDate.of(2024, 5, 18),
                "PENDING", "Kiran Reddy", 11500.00, "QA Testing - May 2024");

        session1.save(inv1);
        session1.save(inv2);
        session1.save(inv3);
        session1.save(inv4);
        session1.save(inv5);

        tx1.commit();
        session1.close();

        System.out.println("Records Inserted Successfully");
        Session session2 = factory.openSession();
        String hql = "FROM Invoice WHERE amount >= ?1";
        Query<Invoice> query = session2.createQuery(hql, Invoice.class);
        query.setParameter(1, 0.0);
        List<Invoice> list = query.getResultList();
        System.out.println("\n========== ALL INVOICE RECORDS ==========");
        System.out.printf("%-5s %-16s %-12s %-12s %-15s %10s%n",
                "ID", "Name", "Date", "Status", "Customer", "Amount");
        System.out.println("-".repeat(80));

        for (Invoice inv : list) {
            System.out.printf("%-5d %-16s %-12s %-12s %-15s %10.2f%n",
                    inv.getId(),
                    inv.getName(),
                    inv.getDate(),
                    inv.getStatus(),
                    inv.getCustomerName(),
                    inv.getAmount());
        }

        System.out.println("-".repeat(80));
        System.out.println("Total Records: " + list.size());

        session2.close();
        factory.close();
    }
}
