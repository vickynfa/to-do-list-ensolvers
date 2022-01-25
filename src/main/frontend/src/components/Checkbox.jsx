import React, { Fragment, useState } from "react";
import TaskService from '../services/TaskService';
import { Pencil } from "react-bootstrap-icons";
import Popup from './PopUp';

const Checkbox = props => {

	const { onChange, data: { taskId, description, isCompleted } } = props;
	const [isOpen, setIsOpen] = useState(false);
	const [newDescription, setNewDescription] = useState();
	const togglePopup = () => {
		setIsOpen(!isOpen);
	}
	const saveTask = (e, newDescription) => {
		 e.preventDefault();
		let editedTask = {
			"taskId": taskId,
			"description": newDescription != "" ? newDescription : description,
			"isCompleted": isCompleted
		};
		const putTask = TaskService.putTask(editedTask);
		putTask.then(togglePopup);
	};


	return (
		<Fragment>
			<label className="to-do-task">
				<input
					className="form-check-input task-checkbox"
					name={taskId}
					type="checkbox"
					defaultChecked={isCompleted}
					onChange={onChange}
				></input>
				<div className=" task-description">{description}</div>
				<button className="task-button btn" name={taskId + "-pencil"} type="button" onClick={togglePopup} >
					<Pencil color="orange" size={10} border="none" />
				</button>
			</label>
			{isOpen && <Popup
				content={<>
					<b>Edit the task</b>

					<div>
						<input
							type="text"
							className="popup-input text"
							
							onChange={e => setNewDescription(e.target.value)}
						/>
					</div>
					<button className="popup-save button orange" onClick={e => saveTask(e, newDescription)}>Save</button>
				</>}
				handleClose={togglePopup}
			/>}
		</Fragment>


	);
};

export default Checkbox;