import axios from "axios";

const BASE_REST_API_URL = 'http://localhost:8080/api/todos';

// function
// export function getAllTodos() {
//     return axios.get(BASE_REST_API_URL);
// }

// arrow function
// export const getAllTodos = () => {
//     return axios.get(BASE_REST_API_URL)
// }

// whenever we use JavaScript arrow func, it has a single statement.
// Then we can also remove the open and close brackets and also the
// return keyword.
export const getAllTodos = () =>  axios.get(BASE_REST_API_URL)

export const saveTodo = (todo) => axios.post(BASE_REST_API_URL, todo)

export const getTodo = (id) => axios.get(BASE_REST_API_URL + '/' + id)

export const updateTodo = (id, todo) => axios.put(BASE_REST_API_URL + '/' + id, todo)

export const deleteTodo = (id) => axios.delete(BASE_REST_API_URL + '/' + id)

export const completeTodo = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/complete')

export const inCompleteTodo = (id) => axios.patch(BASE_REST_API_URL + '/' + id + '/in-complete')
