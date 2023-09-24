<template>
  <div
    id="mychart"
    ref="mychart"
    class="echart"
    :style="{ float: 'left', width: '100%', height: '880px' }"
  />
</template>

<script>
import * as echarts from 'echarts'
import { getRegion } from '@/api/table'
export default {
  name: 'Dashboard',
  data() {
    return {
      initEchart: []
    }
  },
  mounted() {
    this.getList()
  },
  methods: {
    initEcharts() {
      const xAxisData = []
      const seriesData1 = []
      let sum = 0
      const barTopColor = ['#02c3f1', '#53e568', '#a154e9', '#a154e9']
      const barBottomColor = ['rgba(2,195,241,0.1)', 'rgba(83, 229, 104, 0.1)', 'rgba(161, 84, 233, 0.1)', 'rgba(16, 84, 23, 0.1)']
      this.initEchart.forEach(item => {
        xAxisData.push(item.region)
        seriesData1.push(item.count)
        sum += item.count
      })
      const option = {
        backgroundColor: '#061326',
        title: {
          text: '用户地区分布',
          top: 20,
          left: 'center',
          textStyle: {
            color: '#fff',
            fontSize: 20
          }
        },
        grid: {
          top: '25%',
          bottom: '15%'
        },
        xAxis: {
          data: xAxisData,
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          axisLabel: {
            show: true,
            margin: 25,
            align: 'center',
            formatter: function(params, index) {
              return '{a|' + (seriesData1[index] / sum * 100).toFixed(2) + '%}' + '\n' + '{b|' + params + '}'
            },
            textStyle: {
              fontSize: 14,
              color: '#ffffff',
              rich: {
                a: {
                  fontSize: 12,
                  color: '#ffffff'
                },
                b: {
                  height: 20,
                  fontSize: 14,
                  color: '#ffffff'
                }
              }
            }
          },
          interval: 0
        },
        yAxis: {
          splitLine: {
            show: false
          },
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          axisLabel: {
            show: false
          }
        },
        series: [{
          name: '柱顶部',
          type: 'pictorialBar',
          symbolSize: [50, 10],
          symbolOffset: [0, -5],
          z: 12,
          itemStyle: {
            normal: {
              color: function(params) {
                return barTopColor[params.dataIndex]
              }
            }
          },
          label: {
            show: true,
            position: 'top',
            fontSize: 16
          },
          symbolPosition: 'end',
          data: seriesData1
        }, {
          name: '柱底部',
          type: 'pictorialBar',
          symbolSize: [50, 10],
          symbolOffset: [0, 5],
          z: 12,
          itemStyle: {
            normal: {
              color: function(params) {
                return barTopColor[params.dataIndex]
              }
            }
          },
          data: seriesData1
        }, {
          name: '第一圈',
          type: 'pictorialBar',
          symbolSize: [47, 16],
          symbolOffset: [0, 11],
          z: 11,
          itemStyle: {
            normal: {
              color: 'transparent',
              borderColor: '#3ACDC5',
              borderWidth: 5
            }
          },
          data: seriesData1
        }, {
          name: '第二圈',
          type: 'pictorialBar',
          symbolSize: [62, 22],
          symbolOffset: [0, 17],
          z: 10,
          itemStyle: {
            normal: {
              color: 'transparent',
              borderColor: barTopColor[0],
              borderWidth: 5
            }
          },
          data: seriesData1
        }, {
          type: 'bar',
          itemStyle: {
            normal: {
              color: function(params) {
                return new echarts.graphic.LinearGradient(
                  0, 0, 0, 1,
                  [{
                    offset: 1,
                    color: barTopColor[params.dataIndex]
                  },
                  {
                    offset: 0,
                    color: barBottomColor[params.dataIndex]
                  }
                  ]
                )
              },
              opacity: 0.8
            }
          },
          z: 16,
          silent: true,
          barWidth: 50,
          barGap: '-100%', // Make series be overlap
          data: seriesData1
        }]
      }
      const myChart = echarts.init(this.$refs.mychart)// 图标初始化
      myChart.setOption(option)// 渲染页面
      // 随着屏幕大小调节图表
    },
    getList() {
      getRegion().then((res) => {
        this.initEchart = res.data
        console.log(this.initEchart)
      }).then(() => {
        this.initEcharts()
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
