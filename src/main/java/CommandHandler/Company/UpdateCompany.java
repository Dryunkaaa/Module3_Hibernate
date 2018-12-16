package Hibernate.CommandHandler.Company;

import Hibernate.CommandHandler.CommandHandler;
import Hibernate.Entity.Company;
import Hibernate.Storage.AbstractDao;

public class UpdateCompany implements CommandHandler {
    @Override
    public void handleCommand(String[] parameters) {
        if (parameters.length == 3) {
            long id = 0;
            try {
                id = Long.parseLong(parameters[0]);
            } catch (NumberFormatException nbe) {
                System.out.println("Неверный тип введенных данных!");
                return;
            }
            AbstractDao<Company> companyDao = new AbstractDao<>(Company.class);
            Company company = companyDao.getDaoById(id);
            if (company != null) {
                company.setName(parameters[1]);
                company.setCity(parameters[2]);
                companyDao.updateDao(company);
            } else System.out.println("Company not found");
        } else System.out.println("Неверное число параметров!");
    }
}
