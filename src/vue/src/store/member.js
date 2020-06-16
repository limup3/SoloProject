import axios from 'axios'
// import router from "@/router"

const state = {
    context: "http://localhost:5000/",
    member: [],
    fail : false,
    auth : false,
    close : false,
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

              commit("SIGN",data)
              alert("회원가입성공")
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
                    alert('로그인 성공')
                    commit('LOGIN_COMMIT', data)
                }
                else{
                    alert('로그인 실패')
                    commit('FAIL_COMMIT')
                }
            })
            .catch(() => {
                alert('서버 전송 실패')
                state.fail = true
            })
    },
    async logout({commit}){
        alert('로그아웃')
        commit('LOGOUT_COMMIT')}
}

const mutations = {
    LOGIN_COMMIT(state, data){
        state.auth = true
        state.close = true
        state.result = data.result
        state.member = data.member
        localStorage.setItem('token', data.token)
        localStorage.setItem('id',data.member.id)

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