<template>
    <div>
        <h3>검색결과 : {{count}}</h3>
        <v-simple-table>
            <template v-slot:default>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">가 수</th>
                    <th class="text-left">노래제목</th>
                    <th class="text-left">이미지</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item of list" :key="item.seq">
                    <td>{{ item.seq }}</td>
                    <td>{{ item.artist }}</td>
                    <td>{{ item.title }}</td>
                    <td><img :src="item.thumbnail"></td>
                </tr>
                </tbody>
            </template>
        </v-simple-table>
        <div class="text-center">
<!--            <div style="margin: 0 auto; width: 500px; height: 100px">-->
<!--                <span v-if ='pager.existPrev' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">이전</span>-->
<!--                <span v-for='i of pages' :key="i" style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">{{i}}</span>-->
<!--                <span v-if ='pager.existNext' style="width: 50px; height: 50px; border: 1px solid black;margin-right: 5px">다음</span>-->
<!--            </div>-->
            <!--            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>
    </div>


</template>

<script>
    import { mapState } from "vuex";
    export default {
        data () {
            return {
                pageNumber: 0,
                existPrev : true,
                existNext : true,
                pages: [1,2,3,4,5],
                list: [],
                pager: {},
                totalCount: '',
            }
        },
        computed: {
            ...mapState({

                count: state => state.crawling.count,
                pl: state => state.crawling.pl

            })
        }

    }
</script>

<style scoped>

</style>