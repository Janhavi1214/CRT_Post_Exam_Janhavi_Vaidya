import React, { Component } from 'react';

export default class ShowBook extends Component {
    constructor(props) {
        super(props);
        this.state = {
            book: props.book
        };
    }

    render() {
        return (
            <> 
                <td>{this.state.book.isbn}</td>
                <td>{this.state.book.title}</td>
                <td>{this.state.book.author}</td>
                <td>{this.state.book.genre}</td>
                <td>{this.state.book.price}</td>
                <td>
                <button className="btn btn-danger" onClick={() => this.onDelete()}>Delete</button>
                </td>
            </>
        );
    }

    onDelete() {
        if(window.confirm("Are you sure to delete book: " + this.state.book.title + "?"))
            this.props.onDelete(this.state.book.isbn);
    }
}
