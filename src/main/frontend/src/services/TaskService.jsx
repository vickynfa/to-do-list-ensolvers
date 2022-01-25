import axios from "axios";

const TASKS_REST_API = "http://localhost:8080/api/tasks";

class TaskService {

    getTasks() {
        return axios.get(TASKS_REST_API);
    }

    postTask(data) {
        return axios.post(TASKS_REST_API, data);
    }

    putTask(data) {
        return axios.put(TASKS_REST_API + "/" + data.taskId, data);
    }

    deleteTask(taskId) {
        axios.delete(TASKS_REST_API + "/" + taskId)
    }
}

export default new TaskService()