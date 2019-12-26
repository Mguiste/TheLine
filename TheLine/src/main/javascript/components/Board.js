import React from 'react';
import {logging} from 'react-server';

export default class Board extends React.Component {
	constructor(props) {
		super(props);
		this.state = {board: "no board"};
	}

	newBoardClick = () => {
	    this.setState({board: "still nothing"});

	}

	render() {
		return (
			<div>
				<h2>{this.state.board}</h2>
				<button onClick={this.newBoardClick}> Get Board</button>
			</div>
		);
	}
}
