import { createStore } from 'vuex';

export default createStore({
    state: {
        user: null // Здесь будет храниться информация о пользователе
    },
    mutations: {
        setUser(state, userData) {
            state.user = userData;
            localStorage.setItem('user', JSON.stringify(userData));
        },
        clearUser(state) {
            state.user = null;
            localStorage.removeItem('user');
        }
    },
    actions: {
        setUser({ commit }, userData) {
            commit('setUser', userData);
        },
        clearUser({ commit }) {
            commit('clearUser');
        },
        loadUser({ commit }) {
            const userData  = localStorage.getItem('user');
            if (userData) {
                commit('setUser', JSON.parse(userData));
            }
        }

    }
});
