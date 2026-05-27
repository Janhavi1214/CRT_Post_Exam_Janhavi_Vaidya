import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';

export default class FindCode extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            code: '',
            flight: null
        };
    }

    handleChange = (e) => {
        this.setState({
            code: e.target.value
        });
    }

    searchFlight = () => {

        this.service.findByCode(this.state.code)
            .then((response) => {
                this.setState({
                    flight: response.data
                });
            })
            .catch(() => {
                alert('Flight Not Found');
            });
    }

    render() {

        return (
            <div className='container mt-4'>

                <h2>Find Flight By Code</h2>

                <input
                    type='number'
                    placeholder='Enter Code'
                    className='form-control mb-2'
                    value={this.state.code}
                    onChange={this.handleChange}
                />

                <button
                    className='btn btn-success mb-3'
                    onClick={this.searchFlight}
                >
                    Search
                </button>

                {
                    this.state.flight && (
                        <div className='card p-3'>
                            <h5>{this.state.flight.carrier}</h5>
                            <p>{this.state.flight.source} → {this.state.flight.destination}</p>
                            <p>Cost: {this.state.flight.cost}</p>
                        </div>
                    )
                }

            </div>
        );
    }
}
