import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class FindPrice extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            min: '',
            max: '',
            flights: []
        };
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    searchFlights = () => {

        this.service.findByPrice(this.state.min, this.state.max)
            .then((response) => {
                this.setState({
                    flights: response.data
                });
            });
    }

    render() {

        return (
            <div className='container mt-4'>

                <h2>Find By Price</h2>

                <input
                    type='number'
                    name='min'
                    placeholder='Minimum Price'
                    className='form-control mb-2'
                    value={this.state.min}
                    onChange={this.handleChange}
                />

                <input
                    type='number'
                    name='max'
                    placeholder='Maximum Price'
                    className='form-control mb-2'
                    value={this.state.max}
                    onChange={this.handleChange}
                />

                <button
                    className='btn btn-warning mb-3'
                    onClick={this.searchFlights}
                >
                    Search
                </button>

                {
                    this.state.flights.map((flight) => (
                        <div className='card p-2 mb-2' key={flight.code}>
                            <h5>{flight.carrier}</h5>
                            <p>{flight.source} → {flight.destination}</p>
                            <p>Cost: {flight.cost}</p>
                        </div>
                    ))
                }

            </div>
        );
    }
}
