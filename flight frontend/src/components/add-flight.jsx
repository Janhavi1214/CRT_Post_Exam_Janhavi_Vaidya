import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class AddFlight extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            code: '',
            carrier: '',
            source: '',
            destination: '',
            cost: ''
        };
    }

    handleChange = (e) => {

        this.setState({
            [e.target.name]: e.target.value
        });

    }

    saveFlight = () => {

        const flight = {

            code: this.state.code,
            carrier: this.state.carrier,
            source: this.state.source,
            destination: this.state.destination,
            cost: this.state.cost

        };

        this.service.saveFlight(flight)
            .then(() => {

                alert("Flight Added Successfully");

                this.setState({

                    code: '',
                    carrier: '',
                    source: '',
                    destination: '',
                    cost: ''

                });

            })
            .catch((error) => {

                console.log(error);
                alert("Error Adding Flight");

            });
    }

    render() {

        return (

            <div className='form-box'>

                <h2>Add Flight</h2>

                <input
                    type='number'
                    name='code'
                    placeholder='Enter Flight Code'
                    className='input-box'
                    value={this.state.code}
                    onChange={this.handleChange}
                />

                <input
                    type='text'
                    name='carrier'
                    placeholder='Enter Carrier'
                    className='input-box'
                    value={this.state.carrier}
                    onChange={this.handleChange}
                />

                <input
                    type='text'
                    name='source'
                    placeholder='Enter Source'
                    className='input-box'
                    value={this.state.source}
                    onChange={this.handleChange}
                />

                <input
                    type='text'
                    name='destination'
                    placeholder='Enter Destination'
                    className='input-box'
                    value={this.state.destination}
                    onChange={this.handleChange}
                />

                <input
                    type='number'
                    name='cost'
                    placeholder='Enter Cost'
                    className='input-box'
                    value={this.state.cost}
                    onChange={this.handleChange}
                />

                <button
                    className='search-btn'
                    onClick={this.saveFlight}
                >
                    Add Flight
                </button>

            </div>

        );
    }
}