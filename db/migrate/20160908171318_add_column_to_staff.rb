class AddColumnToStaff < ActiveRecord::Migration[5.0]
  def change
    add_column :staffs, :points, :integer
  end
end
