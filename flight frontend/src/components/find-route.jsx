import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class FindRoute extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            source: '',
            destination: '',
            flights: []
        };
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    searchFlights = () => {

        this.service.findByRoute(
            this.state.source,
            this.state.destination
        )
        .then((response) => {
            this.setState({
                flights: response.data
            });
        });
    }

    render() {

        return (
            <div className='container mt-4'>

                <h2>Find By Route</h2>

                <input
                    type='text'
                    name='source'
                    placeholder='Source'
                    className='form-control mb-2'
                    value={this.state.source}
                    onChange={this.handleChange}
                />

                <input
                    type='text'
                    name='destination'
                    placeholder='Destination'
                    className='form-control mb-2'
                    value={this.state.destination}
                    onChange={this.handleChange}
                />

                <button
                    className='btn btn-info mb-3'
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
