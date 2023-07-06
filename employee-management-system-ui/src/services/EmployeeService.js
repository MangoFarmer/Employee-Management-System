import axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/employees";

    const saveEmployee = (employee) => {
        return axios.post(EMPLOYEE_API_BASE_URL, employee);
    }

    const getEmployees = () => {
        return axios.get(EMPLOYEE_API_BASE_URL);
    }

    const getEmployeeById = (id) => {
        return axios.get(EMPLOYEE_API_BASE_URL + "/" + id);
      }

    const updateEmployee = (employee, id) => {
        return axios.put(EMPLOYEE_API_BASE_URL + "/" + id, employee);
      }

    const deleteEmployee = (id) => {
        return axios.delete(EMPLOYEE_API_BASE_URL + "/" + id);
      }

const EmployeeService = {
    saveEmployee,
    getEmployees,
    getEmployeeById,
    updateEmployee,
    deleteEmployee
}

export default EmployeeService;