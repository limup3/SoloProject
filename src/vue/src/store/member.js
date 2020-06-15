import axios from 'axios'
// import router from "@/router"

const state = {
    context: "http://localhost:5000/",
    member: [],
    fail : false,
    auth : false,
    count: 0
}

const actions = {

    async signup({commit},params) {

      axios.post(state.context + `signup`,params,{
          authorization: "JWT fefege..",
          Accept: "application/json",
          "Content-Type": "application/json"
      })
          .then(({data}) => {
              alert('액션')
              commit("SIGN",data)
              alert("데이터 : "+data.data)
          })
          .catch(() => {
              alert('통신실패')
          })
    },

    async login({commit},params) {

        axios.post(state.context + `login`,params,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"
        })
            .then(({data}) => {
                if(data.result){
                    alert('액션 1')
                    commit('LOGIN_COMMIT', data)
                }
                else{
                    alert('액션 2')
                    commit('FAIL_COMMIT')
                }
            })
            .catch(() => {
                alert('서버 전송 실패')
                state.fail = true
            })
    },
    async logout({commit}){
        commit('LOGOUT_COMMIT')}
}

const mutations = {
    LOGIN_COMMIT(state, data){
        state.auth = true
        state.member = data.member
        localStorage.setItem('token', data.token)
        localStorage.setItem('playerId',data.member.id)

    },
    FAIL_COMMIT(state){
        state.fail =true

    },
    LOGOUT_COMMIT(state){
        localStorage.clear()
        state.auth = false
        state.member = {}

    },

};

const getters = {

};

export default {
    name: 'member',
    namespaced : true,
    state,
    actions,
    mutations,
    getters
}