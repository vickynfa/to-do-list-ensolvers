import React, { useState } from 'react';
import TaskService from '../services/TaskService';

import FormToDo from "./FormToDo";
import TaskList from "./TaskList";

const Container = () => {
    const [list, setList] = useState([]);
    const handleAddTask = () => {
        TaskService.getTasks().then(
            (response) => {
                setList(...list, response.data);
            }
        );
        console.log(list);
    };


    return (
        <div>
            <h2>To Do List</h2>

            <TaskList list={list} setList={setList} />
            <FormToDo handleAddTask={handleAddTask} />
        </div>
    );
};

export default Container;