import React from 'react';
import Board from '../components/Board';

export default class Game {
	getElements() {
		return <Board/>;
	}

	getMetaTags() {
		return [
			{charset: 'utf8'},
			{'http-equiv': 'x-ua-compatible', 'content': 'ie=edge'},
			{name: 'viewport', content: 'width=device-width, initial-scale=1'},
			{name: 'description', content: 'TheLine game page'},
			{name: 'generator', content: 'React Server'},
		];
	}
}
