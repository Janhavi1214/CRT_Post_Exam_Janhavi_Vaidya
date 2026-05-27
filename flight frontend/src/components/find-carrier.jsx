import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class FindCarrier extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            carrier: '',
            flights: []
        };
    }

    handleChange = (e) => {
        this.setState({
            carrier: e.target.value
        });
    }

    searchFlight = () => {

        this.service.findByCarrier(this.state.carrier)
            .then((response) => {
                this.setState({
                    flights: response.data
                });
            })
            .catch(() => {
                alert('Flight Not Found');
            });
    }

    render() {

        return (
            <div className='container mt-4'>

                <h2>Find Flight By Carrier</h2>

                <input
                    type='text'
                    placeholder='Enter Carrier'
                    className='form-control mb-2'
                    value={this.state.carrier}
                    onChange={this.handleChange}
                />

                <button
                    className='btn btn-success mb-3'
                    onClick={this.searchFlight}
                >
                    Search
                </button>

                {
                    this.state.flights.map((flight) => (

                        <div className='card p-3 mb-2' key={flight.code}>

                            <h5>{flight.carrier}</h5>

                            <p>
                                {flight.source} → {flight.destination}
                            </p>

                            <p>
                                Cost: {flight.cost}
                            </p>

                        </div>
                    ))
                }

            </div>
        );
    }
}