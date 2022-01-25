import React from "react";
import Checkbox from "./Checkbox";
import TaskService from '../services/TaskService';

const TaskList = props => {
    const { list, setList } = props;

    const onChangeStatus = e => {
        const { name, checked } = e.target;
        const updateList = list.map(item => ({
            ...item,
            isCompleted: item.taskId == name ? checked : item.isCompleted
        }));
        setList(updateList);
        updateTask(list);
    };


    const chk = list.map(item => (
        <Checkbox key={item.taskId} data={item} onChange={onChangeStatus}/>
    ));

    const onClickRemoveTask = e => {
        const updatedList = list.filter(item => !item.isCompleted);
        for (var i in updatedList) {
            TaskService.deleteTask(updatedList[i].taskId);
        }
        const tasks = TaskService.getTasks().then((response) => setList(response.data));
    };

    const updateTask = (updatedList) => {
        for (var i in updatedList) {
            TaskService.putTask(updatedList[i]);
        }

    };

    return (
        <div className="todo-list">
            {list.length ? chk : "There are no tasks to do"}
            {list.length ? (
                <p>
                    <button className="button pink" onClick={onClickRemoveTask}>
                        Delete all done
                    </button>
                </p>
            ) : null}
        </div> 
    );
};

export default TaskList;