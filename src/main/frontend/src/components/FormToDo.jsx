import React, { useState } from "react";
import TaskService from '../services/TaskService';


const FormToDo = props => {
    const [description, setDescription] = useState("");
    const { handleAddTask } = props;
    const handleSubmit = e => {
        e.preventDefault();
        console.log(description);
        TaskService.postTask({
            "description": description,
            "isCompleted": false
        }).then(() => { handleAddTask(); });
        //call service add task
        setDescription("");
    };
    return (
        <form onSubmit={handleSubmit}>
            <div className="todo-list">
                <div className="file-input">
                    <input
                        type="text"
                        className="text"
                        value={description}
                        onChange={e => setDescription(e.target.value)}
                    />
                    <button
                        className="button blue"
                        disabled={description ? "" : "disabled"}
                    >
                        Add
                    </button>

                </div>
            </div>
        </form>
    );
}

export default FormToDo;